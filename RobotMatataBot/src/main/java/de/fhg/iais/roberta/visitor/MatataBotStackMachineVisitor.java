package de.fhg.iais.roberta.visitor;

import java.util.List;

import org.json.JSONObject;

import de.fhg.iais.roberta.bean.UsedHardwareBean;
import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.components.ConfigurationComponent;
import de.fhg.iais.roberta.inter.mode.action.IDriveDirection;
import de.fhg.iais.roberta.syntax.MotorDuration;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.action.motor.MotorOnAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorStopAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.CurveAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.DriveAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.MotorDriveStopAction;
import de.fhg.iais.roberta.syntax.action.motor.differential.TurnAction;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerSensor;
import de.fhg.iais.roberta.util.dbc.DbcException;
import de.fhg.iais.roberta.visitor.hardware.IMatataBotVisitor;
import de.fhg.iais.roberta.visitor.lang.codegen.AbstractStackMachineVisitor;

public final class MatataBotStackMachineVisitor<V> extends AbstractStackMachineVisitor<V> implements IMatataBotVisitor<V> {

    public MatataBotStackMachineVisitor(UsedHardwareBean usedHardwareBean, ConfigurationAst configuration, List<List<Phrase<Void>>> phrases) {
        super(configuration);
    }

    @Override
    protected V app(JSONObject o) {
        this.getOpArray().add(o);
        return null;
    }

    @Override
    protected JSONObject mk(String opCode, Phrase<V> phrase) {
        return super.mk(opCode);
    }

    @Override
    public V visitTimerSensor(TimerSensor<V> timerSensor) {
        JSONObject o;
        switch ( timerSensor.getMode() ) {
            case "DEFAULT":
            case "VALUE":
                o = mk(C.GET_SAMPLE).put(C.GET_SAMPLE, C.TIMER).put(C.PORT, timerSensor.getPort());
                break;
            case "RESET":
                o = mk(C.TIMER_SENSOR_RESET).put(C.PORT, timerSensor.getPort());
                break;
            default:
                throw new DbcException("Invalid Timer Mode " + timerSensor.getMode());
        }
        return app(o);
    }

    @Override
    public V visitDriveAction(DriveAction<V> driveAction) {
        driveAction.getParam().getSpeed().accept(this);
        driveAction.getParam().getDuration().getValue().accept(this);
        IDriveDirection driveDirection = driveAction.getDirection();
        if ( driveDirection != null ) {
            JSONObject o = mk(C.DRIVE_ACTION, driveAction).put(C.DRIVE_DIRECTION, driveDirection).put(C.SPEED_ONLY, false).put(C.SET_TIME, false).put(C.NAME, "matatabot");
            return app(o);
        } else {
            throw new DbcException("No robot name or no port");
        }
    }

    @Override
    public V visitMotorOnAction(MotorOnAction<V> motorOnAction) {
        ConfigurationComponent confMotorBlock = getConfigurationComponent(motorOnAction.getUserDefinedPort());
        String brickName = confMotorBlock.getProperty("VAR");
        String port = confMotorBlock.getProperty("CONNECTOR");
        if ( brickName != null && port != null ) {
            motorOnAction.getParam().getSpeed().accept(this);
            MotorDuration<V> duration = motorOnAction.getParam().getDuration();
            boolean speedOnly = !processOptionalDuration(duration);
            JSONObject o = mk(C.MOTOR_ON_ACTION).put(C.NAME, brickName).put(C.PORT, port).put(C.SPEED_ONLY, speedOnly).put(C.SPEED_ONLY, speedOnly);
            if ( speedOnly ) {
                return app(o);
            } else {
                app(o);
                return app(mk(C.MOTOR_STOP).put(C.NAME, brickName).put(C.PORT, port));
            }
        } else {
            throw new DbcException("No robot name or no port");
        }
    }

    @Override
    public V visitMotorStopAction(MotorStopAction<V> motorStopAction) {
        ConfigurationComponent confMotorBlock = getConfigurationComponent(motorStopAction.getUserDefinedPort());
        String brickName = confMotorBlock.getProperty("VAR");
        String port = confMotorBlock.getProperty("CONNECTOR");
        if ( brickName != null && port != null ) {
            JSONObject o = mk(C.MOTOR_STOP).put(C.NAME, brickName).put(C.PORT, port);
            return app(o);
        } else {
            throw new DbcException("No robot name or no port");
        }
    }

    @Override
    public V visitCurveAction(CurveAction<V> curveAction) {
        throw new DbcException("No robot name or no port");
    }

    @Override
    public V visitTurnAction(TurnAction<V> turnAction) {
        throw new DbcException("No robot name or no port");
    }

    @Override
    public V visitMotorDriveStopAction(MotorDriveStopAction<V> stopAction) {
        throw new DbcException("No robot name or no port");
    }
}
