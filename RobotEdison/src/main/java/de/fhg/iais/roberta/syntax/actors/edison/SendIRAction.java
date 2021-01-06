package de.fhg.iais.roberta.syntax.actors.edison;

import java.util.List;

import de.fhg.iais.roberta.blockly.generated.Block;
import de.fhg.iais.roberta.blockly.generated.Value;
import de.fhg.iais.roberta.syntax.BlockTypeContainer;
import de.fhg.iais.roberta.syntax.BlocklyBlockProperties;
import de.fhg.iais.roberta.syntax.BlocklyComment;
import de.fhg.iais.roberta.syntax.BlocklyConstants;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.syntax.lang.expr.ColorConst;
import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.transformer.AbstractJaxb2Ast;
import de.fhg.iais.roberta.transformer.Ast2JaxbHelper;
import de.fhg.iais.roberta.transformer.ExprParam;
import de.fhg.iais.roberta.typecheck.BlocklyType;
import de.fhg.iais.roberta.visitor.IVisitor;
import de.fhg.iais.roberta.visitor.hardware.IEdisonVisitor;

public class SendIRAction<V> extends Action<V> {
    private final Expr<V> code;

    private SendIRAction(Expr<V> code, BlocklyBlockProperties properties, BlocklyComment comment) {
        super(BlockTypeContainer.getByName("IR_SEND"), properties, comment);
        this.code = code;
        setReadOnly();
    }

    /**
     * Creates instance of {@link SendIRAction}. This instance is read only and can not be modified.
     *
     * @param ledColor {@link ColorConst} color of the led; must <b>not</b> be null,
     * @param properties of the block (see {@link BlocklyBlockProperties}),
     * @param comment added from the user,
     * @return read only object of class {@link SendIRAction}
     */
    private static <V> SendIRAction<V> make(Expr<V> code, BlocklyBlockProperties properties, BlocklyComment comment) {
        return new SendIRAction<>(code, properties, comment);
    }

    @Override
    public String toString() {
        return "LedOnAction [ " + this.code + " ]";
    }

    @Override
    protected V acceptImpl(IVisitor<V> visitor) {
        return ((IEdisonVisitor<V>) visitor).visitSendIRAction(this);
    }

    public Expr<V> getCode() {
        return this.code;
    }

    /**
     * Transformation from JAXB object to corresponding AST object.
     *
     * @param block for transformation
     * @param helper class for making the transformation
     * @return corresponding AST object
     */
    public static <V> Phrase<V> jaxbToAst(Block block, AbstractJaxb2Ast<V> helper) {
        List<Value> values = AbstractJaxb2Ast.extractValues(block, (short) 1);
        Phrase<V> code = helper.extractValue(values, new ExprParam(BlocklyConstants.MESSAGE, BlocklyType.NUMBER));
        return SendIRAction.make(helper.convertPhraseToExpr(code), AbstractJaxb2Ast.extractBlockProperties(block), AbstractJaxb2Ast.extractComment(block));
    }

    @Override
    public Block astToBlock() {
        Block jaxbDestination = new Block();
        Ast2JaxbHelper.setBasicProperties(this, jaxbDestination);
        Ast2JaxbHelper.addValue(jaxbDestination, BlocklyConstants.MESSAGE, this.code);
        return jaxbDestination;

    }
}
