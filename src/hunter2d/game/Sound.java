package hunter2d.game;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	private Clip clip;

	public Sound(String path) {
		try {
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource(path));

			AudioFormat baseFormat = inputStream.getFormat();
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);

			AudioInputStream decodeInputStream = AudioSystem.getAudioInputStream(decodeFormat, inputStream);

			clip = AudioSystem.getClip();
			clip.open(decodeInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		if (clip == null) {
			return;
		}
		stop();
		clip.setFramePosition(0);
		clip.start();
	}

	public void close() {
		stop();
		clip.close();
	}

	public void stop() {
		if (clip.isRunning()) {
			clip.stop();
		}
	}
}
