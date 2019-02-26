package POOP;

public class Sound {
	
	private int[] samples;

	private int limitAmplitude(int limit) {
		int changed = 0;
		for (int i = 0; i < samples.length; i++) {
			if (samples[i] > limit) {
				samples[i] = limit;
				changed++;
			}
			if (samples[i] < -limit) {
				samples[i] = -limit;
				changed++;
			}
		}
		return changed;
		
	}
	
	public void trimSilenceFromBeginning() {
		int[] changedarray;
	}
}
