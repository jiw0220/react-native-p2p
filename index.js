import {NativeModules} from 'react-native';

var P2P = NativeModules.P2P;
export default {
    registerP2PClass: P2P.registerP2PClass,
    doSave: P2P.doSave,
    doStart: P2P.doStart,
    doAdd: P2P.doAdd,
    doSetUpMax: P2P.doSetUpMax,
    doSetDownMax: P2P.doSetDownMax,
    doDownload: P2P.doDownload,
    doPause: P2P.doPause,
    doDel: P2P.doDel,
    doCheck: P2P.doCheck,
    doTerminate: P2P.doTerminate,
    doStartHttpd: P2P.doStartHttpd,
    doEndHttpd: P2P.doEndHttpd,
    doSetDuration: P2P.doSetDuration,
    getSpeed: P2P.getSpeed,
    getDownSize: P2P.getDownSize,
    getFileSize: P2P.getFileSize,
    getPercent: P2P.getPercent,
    getLocalFileSize: P2P.getLocalFileSize,
    getTaskStatusCode: P2P.getTaskStatusCode,
    getTaskInfo: P2P.getTaskInfo,
    doTest: P2P.doTest
};
