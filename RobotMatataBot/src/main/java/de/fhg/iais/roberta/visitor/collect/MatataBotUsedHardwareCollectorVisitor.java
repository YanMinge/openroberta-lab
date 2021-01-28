package de.fhg.iais.roberta.visitor.collect;

import com.google.common.collect.ClassToInstanceMap;

import de.fhg.iais.roberta.bean.IProjectBean;
import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.visitor.hardware.actor.IDifferentialMotorVisitor;
import de.fhg.iais.roberta.syntax.action.motor.differential.DriveAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.CurveAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.TurnAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.MotorDriveStopAction;

public class MatataBotUsedHardwareCollectorVisitor extends AbstractUsedHardwareCollectorVisitor implements IDifferentialMotorVisitor<Void> {

    public MatataBotUsedHardwareCollectorVisitor(ConfigurationAst configuration, ClassToInstanceMap<IProjectBean.IBuilder<?>> beanBuilders) {
        super(configuration, beanBuilders);
    }

    @Override
    public Void visitDriveAction(DriveAction<Void> driveAction) {
        driveAction.getDirection();
        return null;
    }       

    @Override
    public Void visitCurveAction(CurveAction<Void> curveAction) {
        return null;
    }

    @Override
    public Void visitTurnAction(TurnAction<Void> turnAction) {
        return null;
    }

    @Override
    public Void visitMotorDriveStopAction(MotorDriveStopAction<Void> stopAction) {
        return null;
    }
}
