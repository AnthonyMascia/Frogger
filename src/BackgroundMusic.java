import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Control;
import javax.sound.sampled.Control.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class BackgroundMusic implements Clip{
	

//Override start function to play clip
@Override
public void start() {
		try {
	        AudioInputStream audio = AudioSystem.getAudioInputStream(new File("froggerMusic.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audio);
	        //Music will always loop until program executes
	        clip.loop(LOOP_CONTINUOUSLY);
	    }
	    
	    catch(UnsupportedAudioFileException uae) {
	        System.out.println(uae);
	    }
	    catch(IOException ioe) {
	        System.out.println(ioe);
	    }
	    catch(LineUnavailableException lua) {
	        System.out.println(lua);
	    }
}
@Override
public int available() {return 0;}

@Override
public void drain() {;}

@Override
public void flush() {;}

@Override
public int getBufferSize() {return 0;}

@Override
public AudioFormat getFormat() {return null;}

@Override
public int getFramePosition() {return 0;}

@Override
public float getLevel() {return 0;}

@Override
public long getLongFramePosition() {return 0;}

@Override
public long getMicrosecondPosition() {return 0;}

@Override
public boolean isActive() {return false;}

@Override
public boolean isRunning() {return false;}	

@Override
public void stop() {;}

@Override
public void addLineListener(LineListener listener) {;}

@Override
public void close() {;}

@Override
public Control getControl(Type control) {return null;}

@Override
public Control[] getControls() {return null;}

@Override
public javax.sound.sampled.Line.Info getLineInfo() {return null;}

@Override
public boolean isControlSupported(Type control) {return false;}

@Override
public boolean isOpen() {return false;}

@Override
public void open() throws LineUnavailableException {;}

@Override
public void removeLineListener(LineListener listener) {;}

@Override
public int getFrameLength() {return 0;}

@Override
public long getMicrosecondLength() {return 0;}

@Override
public void loop(int arg0) {;}

@Override
public void open(AudioInputStream arg0) throws LineUnavailableException,
		IOException {}

@Override
public void open(AudioFormat arg0, byte[] arg1, int arg2, int arg3)
		throws LineUnavailableException {;}

@Override
public void setFramePosition(int arg0) {;}

@Override
public void setLoopPoints(int arg0, int arg1) {;}

@Override
public void setMicrosecondPosition(long arg0) {;}


	
}
