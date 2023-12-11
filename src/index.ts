import ExpoAudioListenerModule from './ExpoAudioListenerModule';

export function addListener(listener: (event: any) => void) {
  return ExpoAudioListenerModule.addListener('onAudioModeChanged', listener);
}

export function removeAllListeners() {
  return ExpoAudioListenerModule.removeAllListeners('onAudioModeChanged');
}
