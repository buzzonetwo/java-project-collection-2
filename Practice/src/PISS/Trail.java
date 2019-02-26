package PISS;

public class Trail {

	private int[] markers;
	
	public boolean isLevelTrailSegment(int start, int end) {
		int temp1 = 0;
		int temp2 = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			if (markers[i] > temp1) {
				temp1 = markers[i];
			}
		}
		for (int i = start; i <= end; i++) {
			if (markers[i] < temp2) {
				temp2 = markers[i];
			}
		}
		if (Math.abs(temp1 - temp2) <= 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isDifficult() {
		int temp1 = 0;
		for (int i = 1; i < markers.length; i++) {
			if (Math.abs(markers[i] - markers[i-1]) <= 30) {
				temp1++;
			}
		}
		if (temp1 >= 3) {
			return true;
		}
		else {
			return false;
		}
	}
}
