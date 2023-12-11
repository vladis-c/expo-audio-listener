import {EventEmitter, requireNativeModule} from 'expo-modules-core';

const AudioModule = requireNativeModule('AudioListener');
const emitter = new EventEmitter(AudioModule);
export default emitter;
