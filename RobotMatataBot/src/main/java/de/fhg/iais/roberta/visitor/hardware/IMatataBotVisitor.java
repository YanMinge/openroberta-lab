package de.fhg.iais.roberta.visitor.hardware;

import de.fhg.iais.roberta.syntax.action.motor.MotorGetPowerAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorSetPowerAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.CurveAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.DriveAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.MotorDriveStopAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.TurnAction;
import de.fhg.iais.roberta.util.dbc.DbcException;
import de.fhg.iais.roberta.visitor.hardware.actor.IDifferentialMotorVisitor;

public interface IMatataBotVisitor<V> extends IDifferentialMotorVisitor<V> {

    @Override
    default V visitDriveAction(DriveAction<V> driveAction) {
        throw new DbcException("operation not supported");
    }

    @Override
    default V visitCurveAction(CurveAction<V> curveAction) {
        throw new DbcException("operation not supported");
    }

    @Override
    default V visitTurnAction(TurnAction<V> turnAction) {
        throw new DbcException("operation not supported");
    }

    @Override
    default V visitMotorDriveStopAction(MotorDriveStopAction<V> stopAction) {
        throw new DbcException("operation not supported");
    }

    @Override
    default V visitMotorGetPowerAction(MotorGetPowerAction<V> motorGetPowerAction) {
        throw new DbcException("operation not supported");
    }

    @Override
    default V visitMotorSetPowerAction(MotorSetPowerAction<V> motorSetPowerAction) {
        throw new DbcException("operation not supported");
    }
}
