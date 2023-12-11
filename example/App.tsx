import {StyleSheet, Text, View} from 'react-native';

import * as ExpoAudioListener from 'expo-audio-listener';
import {useEffect} from 'react';

export default function App() {
  useEffect(() => {
    ExpoAudioListener.addListener(e => console.log('e', e));
    return () => ExpoAudioListener.removeAllListeners();
  }, []);

  return (
    <View style={styles.container}>
      <Text>My app</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
