var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
define(["require", "exports", "./interpreter.aRobotBehaviour", "./interpreter.util"], function (require, exports, interpreter_aRobotBehaviour_1, U) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    var RobotMatataBotBehaviour = (function (_super) {
        __extends(RobotMatataBotBehaviour, _super);
        function RobotMatataBotBehaviour(btInterfaceFct, toDisplayFct) {
            var _this = _super.call(this) || this;
            _this.matatabot = {};
            _this.btInterfaceFct = btInterfaceFct;
            _this.toDisplayFct = toDisplayFct;
            _this.timers = {};
            _this.timers['start'] = Date.now();
            _this.commandSyncFlag = {
                motionForwardStepFlag: false,
                motionBackwardStepFlag: false
            };
            U.loggingEnabled(true, true);
            return _this;
        }
        RobotMatataBotBehaviour.prototype.update = function (data) {
            U.info('update type:' + data.type + ' state:' + data.state + ' brickid:' + data.brickid);
            U.debug('update type:' + data.type + ' state:' + data.state + ' brickid:' + data.brickid);
            if (data.target !== "matatabot") {
                return;
            }
            switch (data.type) {
                case "connect":
                    if (data.state == "connected") {
                        this.matatabot[data.brickid] = {};
                        this.matatabot[data.brickid]["brickname"] = data.brickname.replace(/\s/g, '').toUpperCase();
                        // for some reason we do not get the inital state of the button, so here it is hardcoded
                    }
                    else if (data.state == "disconnected") {
                        delete this.matatabot[data.brickid];
                    }
                    break;
                case "commandResponse":
                    if (data.state == "motionForwardStep") {
                        this.commandSyncFlag.motionForwardStepFlag = false;
                        this.setBlocking(false);
                    }
                    else if (data.state == "motionBackwardStep") {
                        this.commandSyncFlag.motionBackwardStepFlag = false;
                        this.setBlocking(false);
                    }
                    break;
                default:
                    // TODO think about what could happen here.
                    break;
            }
            U.info(this.matatabot);
        };
        RobotMatataBotBehaviour.prototype.getConnectedBricks = function () {
            var brickids = [];
            for (var brickid in this.matatabot) {
                if (this.matatabot.hasOwnProperty(brickid)) {
                    brickids.push(brickid);
                }
            }
            return brickids;
        };
        RobotMatataBotBehaviour.prototype.getBrickIdByName = function (name) {
            for (var brickid in this.matatabot) {
                if (this.matatabot.hasOwnProperty(brickid)) {
                    if (this.matatabot[brickid].brickname === name.toUpperCase()) {
                        return brickid;
                    }
                }
            }
            return null;
        };
        RobotMatataBotBehaviour.prototype.getBrickById = function (id) {
            return this.matatabot[id];
        };
        RobotMatataBotBehaviour.prototype.close = function () {
            var ids = this.getConnectedBricks();
            for (var id in ids) {
                if (ids.hasOwnProperty(id)) {
                    var name = this.getBrickById(ids[id]).brickname;
                }
            }
        };
        RobotMatataBotBehaviour.prototype.driveAction = function (_name, _direction, _speed, _distance) {
            var brickid = this.getBrickIdByName(name);
            var robotText = 'robot: ' + name + ', _distance: ' + _distance;
            U.debug(robotText + ' matatabotMotionForwardStep');
            U.info(robotText + brickid);
            var cmd = { 'target': 'matatabot', 'type': 'command', 'actuator': 'motor', 'brickid': brickid, 'action': 'driveAction', 'direction': _direction, 'step': _distance };
            if (_direction === "FOREWARD") {
                this.commandSyncFlag.motionForwardStepFlag = true;
            }
            else {
                this.commandSyncFlag.motionBackwardStepFlag = true;
            }
            this.btInterfaceFct(cmd);
            this.setBlocking(true);
            return 0;
        };
        RobotMatataBotBehaviour.prototype.encoderReset = function (_port) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.clearDisplay = function () {
            U.debug('clear display');
            this.toDisplayFct({ "clear": true });
        };
        RobotMatataBotBehaviour.prototype.showTextAction = function (text, _mode) {
            var showText = "" + text;
            U.debug('***** show "' + showText + '" *****');
            this.toDisplayFct({ "show": showText });
            return 0;
        };
        RobotMatataBotBehaviour.prototype.showImageAction = function (_text, _mode) {
            U.debug('***** show image not supported by WeDo *****');
            return 0;
        };
        RobotMatataBotBehaviour.prototype.displaySetBrightnessAction = function (_value) {
            return 0;
        };
        RobotMatataBotBehaviour.prototype.displaySetPixelAction = function (_x, _y, _brightness) {
            return 0;
        };
        RobotMatataBotBehaviour.prototype.timerReset = function (port) {
            this.timers[port] = Date.now();
            U.debug('timerReset for ' + port);
        };
        RobotMatataBotBehaviour.prototype.timerGet = function (port) {
            var now = Date.now();
            var startTime = this.timers[port];
            if (startTime === undefined) {
                startTime = this.timers['start'];
            }
            var delta = now - startTime;
            U.debug('timerGet for ' + port + ' returned ' + delta);
            return delta;
        };
        RobotMatataBotBehaviour.prototype.writePinAction = function (_pin, _mode, _value) {
        };
        RobotMatataBotBehaviour.prototype.getSample = function (s, name, sensor, port, slot) {
        };
        RobotMatataBotBehaviour.prototype.ledOnAction = function (name, port, color) {
        };
        RobotMatataBotBehaviour.prototype.motorOnAction = function (name, port, duration, speed) {
            return 0;
        };
        RobotMatataBotBehaviour.prototype.motorStopAction = function (name, port) {
        };
        RobotMatataBotBehaviour.prototype.statusLightOffAction = function (name, port) {
        };
        RobotMatataBotBehaviour.prototype.toneAction = function (name, frequency, duration) {
            return duration;
        };
        RobotMatataBotBehaviour.prototype.gyroReset = function (_port) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.lightAction = function (_mode, _color, _port) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.playFileAction = function (_file) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype._setVolumeAction = function (_volume) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype._getVolumeAction = function (_s) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.setLanguage = function (_language) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.sayTextAction = function (_text, _speed, _pitch) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.getMotorSpeed = function (_s, _name, _port) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.setMotorSpeed = function (_name, _port, _speed) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.driveStop = function (_name) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.curveAction = function (_name, _direction, _speedL, _speedR, _distance) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.turnAction = function (_name, _direction, _speed, _angle) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.showTextActionPosition = function (_text, _x, _y) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.displaySetPixelBrightnessAction = function (_x, _y, _brightness) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.displayGetPixelBrightnessAction = function (_s, _x, _y) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.setVolumeAction = function (_volume) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.getVolumeAction = function (_s) {
            throw new Error("Method not implemented.");
        };
        RobotMatataBotBehaviour.prototype.debugAction = function (_value) {
            this.showTextAction("> " + _value, undefined);
        };
        RobotMatataBotBehaviour.prototype.assertAction = function (_msg, _left, _op, _right, _value) {
            if (!_value) {
                this.showTextAction("> Assertion failed: " + _msg + " " + _left + " " + _op + " " + _right, undefined);
            }
        };
        return RobotMatataBotBehaviour;
    }(interpreter_aRobotBehaviour_1.ARobotBehaviour));
    exports.RobotMatataBotBehaviour = RobotMatataBotBehaviour;
});
