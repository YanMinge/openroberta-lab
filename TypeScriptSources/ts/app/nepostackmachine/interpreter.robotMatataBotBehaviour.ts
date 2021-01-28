import { ARobotBehaviour } from "./interpreter.aRobotBehaviour";
import { State } from "./interpreter.state";
import * as C from "./interpreter.constants";
import * as U from "./interpreter.util";

export class RobotMatataBotBehaviour extends ARobotBehaviour {
    private btInterfaceFct;
    private toDisplayFct;
    private timers;
    private commandSyncFlag;
    private matatabot = {};

    constructor( btInterfaceFct: any, toDisplayFct: any ) {
        super();
        this.btInterfaceFct = btInterfaceFct;
        this.toDisplayFct = toDisplayFct;
        this.timers = {};
        this.timers['start'] = Date.now();
        this.commandSyncFlag = {
            motionForwardStepFlag: false,
            motionBackwardStepFlag: false
        };

        U.loggingEnabled( true, true );
    }

    public update( data ) {
        U.info( 'update type:' + data.type + ' state:' + data.state + ' brickid:' + data.brickid );
        U.debug( 'update type:' + data.type + ' state:' + data.state + ' brickid:' + data.brickid );
        if ( data.target !== "matatabot" ) {
            return;
        }
        switch ( data.type ) {
            case "connect":
                if ( data.state == "connected" ) {
                    this.matatabot[data.brickid] = {};
                    this.matatabot[data.brickid]["brickname"] = data.brickname.replace( /\s/g, '' ).toUpperCase();
                    // for some reason we do not get the inital state of the button, so here it is hardcoded
                } else if ( data.state == "disconnected" ) {
                    delete this.matatabot[data.brickid];
                }
                break;
            case "commandResponse":
                if (data.state == "motionForwardStep") {
                    this.commandSyncFlag.motionForwardStepFlag = false;
                    this.setBlocking(false);
                }
                else  if (data.state == "motionBackwardStep") {
                    this.commandSyncFlag.motionBackwardStepFlag = false;
                    this.setBlocking(false);
                }
                break;
            default:
                // TODO think about what could happen here.
                break;
        }
        U.info( this.matatabot );
    }

    public getConnectedBricks() {
        var brickids = [];
        for ( var brickid in this.matatabot ) {
            if ( this.matatabot.hasOwnProperty( brickid ) ) {
                brickids.push( brickid );
            }
        }
        return brickids;
    }

    public getBrickIdByName( name ) {
        for ( var brickid in this.matatabot ) {
            if ( this.matatabot.hasOwnProperty( brickid ) ) {
                if ( this.matatabot[brickid].brickname === name.toUpperCase() ) {
                    return brickid;
                }
            }
        }
        return null;
    }

    public getBrickById( id ) {
        return this.matatabot[id];
    }

    public close() {
        var ids = this.getConnectedBricks();
        for ( let id in ids ) {
            if ( ids.hasOwnProperty( id ) ) {
                var name = this.getBrickById( ids[id] ).brickname;
            }
        }
    }

    public  driveAction( _name: string, _direction: string, _speed: number, _distance: number ): number {
        var brickid = this.getBrickIdByName( name );
        const robotText = 'robot: ' + name + ', _distance: ' + _distance;
        U.debug( robotText + ' matatabotMotionForwardStep' );
        U.info(robotText + brickid);
        const cmd = { 'target': 'matatabot', 'type': 'command', 'actuator': 'motor', 'brickid': brickid, 'action': 'driveAction', 'direction': _direction,  'step': _distance };
        if (_direction === "FOREWARD") {
            this.commandSyncFlag.motionForwardStepFlag = true;
        } else {
            this.commandSyncFlag.motionBackwardStepFlag = true;
        }
        this.btInterfaceFct( cmd );
        this.setBlocking(true);
        return 0;
    }
    
    public encoderReset( _port: string ): void {
        throw new Error( "Method not implemented." );
    }
    
    public clearDisplay() {
        U.debug( 'clear display' );
        this.toDisplayFct( { "clear": true } );
    }
    
    public showTextAction( text: any, _mode: string ): number {
        const showText = "" + text;
        U.debug( '***** show "' + showText + '" *****' );
        this.toDisplayFct( { "show": showText } );
        return 0;
    }

    public showImageAction( _text: any, _mode: string ): number {
        U.debug( '***** show image not supported by WeDo *****' );
        return 0;
    }

    public displaySetBrightnessAction( _value: number ): number {
        return 0;
    }

    public displaySetPixelAction( _x: number, _y: number, _brightness: number ): number {
        return 0;
    }
    
    public timerReset( port: number ) {
        this.timers[port] = Date.now();
        U.debug( 'timerReset for ' + port );
    }

    public timerGet( port: number ) {
        const now = Date.now();
        var startTime = this.timers[port];
        if ( startTime === undefined ) {
            startTime = this.timers['start'];
        }
        const delta = now - startTime;
        U.debug( 'timerGet for ' + port + ' returned ' + delta );
        return delta;
    }

    public writePinAction( _pin: any, _mode: string, _value: number ): void {
    }
    
    public getSample( s: State, name: string, sensor: string, port: number, slot: string ) {
    }
    
    public ledOnAction( name: string, port: number, color: number ) {
    }
    
    public motorOnAction( name: string, port: any, duration: number, speed: number ): number {
        return 0;
    }

    public motorStopAction( name: string, port: number ) {
    }
    
    public statusLightOffAction( name: string, port: number ) {
    }

    public toneAction( name: string, frequency: number, duration: number ) {
        return duration;
    }
    
    public gyroReset( _port: number ): void {
        throw new Error( "Method not implemented." );
    }

    public lightAction( _mode: string, _color: string,_port: string ): void {
        throw new Error( "Method not implemented." );
    }

    public playFileAction( _file: string ): number {
        throw new Error( "Method not implemented." );
    }

    public _setVolumeAction( _volume: number ): void {
        throw new Error( "Method not implemented." );
    }

    public _getVolumeAction( _s: State ): void {
        throw new Error( "Method not implemented." );
    }

    public setLanguage( _language: string ): void {
        throw new Error( "Method not implemented." );
    }

    public sayTextAction( _text: string, _speed: number, _pitch: number ): number {
        throw new Error( "Method not implemented." );
    }

    public getMotorSpeed( _s: State, _name: string, _port: any ): void {
        throw new Error( "Method not implemented." );
    }

    public setMotorSpeed( _name: string, _port: any, _speed: number ): void {
        throw new Error( "Method not implemented." );
    }

    public driveStop( _name: string ): void {
        throw new Error( "Method not implemented." );
    }
    
    public curveAction( _name: string, _direction: string, _speedL: number, _speedR: number, _distance: number ): number {
        throw new Error( "Method not implemented." );
    }

    public turnAction( _name: string, _direction: string, _speed: number, _angle: number ): number {
        throw new Error( "Method not implemented." );
    }

    public showTextActionPosition( _text: any, _x: number, _y: number ): void {
        throw new Error( "Method not implemented." );
    }

    public displaySetPixelBrightnessAction( _x: number, _y: number, _brightness: number ): number {
        throw new Error( "Method not implemented." );
    }

    public displayGetPixelBrightnessAction( _s: State, _x: number, _y: number ): void {
        throw new Error( "Method not implemented." );
    }

    public setVolumeAction( _volume: number ): void {
        throw new Error( "Method not implemented." );
    }
    public getVolumeAction( _s: State ): void {
        throw new Error( "Method not implemented." );
    }
    public debugAction( _value: any ): void {
        this.showTextAction( "> " + _value, undefined );
    }
    public assertAction( _msg: string, _left: any, _op: string, _right: any, _value: any ): void {
        if ( !_value ) {
            this.showTextAction( "> Assertion failed: " + _msg + " " + _left + " " + _op + " " + _right, undefined );
        }
    }
    
}
