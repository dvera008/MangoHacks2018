package org.memeteam.util;

import java.io.File;
import java.net.URI;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sound {
	/**
	 * Plays a .wav file
	 * 
	 * example usage:
	 * 
	 * <code>
	 *		public SourceCode() {
	 *			frame = new JFrame("hi");
	 *			// the program must stay alive to make noise
	 *			playWav("hitsound", "org/memeteam/resources");
	 *		}
	 *</code>
	 * 
	 * @param filename
	 * @param filepath
	 */
	public void playWav(String filename, String filepath) {
		try {
			URI i = new URI("");
			if (filepath.equals("") || filepath.equals(null)) {
				i = new URI(getClass().getResource("/" + filename + ".wav").toString());
			} else {
				i = new URI(getClass().getResource("/" + filepath + "/" + filename + ".wav").toString());
			}
			File file = new File(i);
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			Clip clip;
			stream = AudioSystem.getAudioInputStream(file);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
