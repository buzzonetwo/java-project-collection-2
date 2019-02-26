
/**
 * This is the model
 * @author buzzonetwo
 *
 */
public class WindowManager {
	
	private DList<WindowRect> rectlist;
	/**
	 * Creates a new WindowManager containing a doubly linked list of WindowRects
	 */
	public WindowManager() {
		rectlist = new DList<WindowRect>();
	}
	
	
	/**
	 * Returns the WindowRect list of this manager
	 * @return the WindowRect list of this manager 
	 */
	public DList<WindowRect> getRectList() {
		return rectlist;
	}
	/**
	 * Cleans up the WindowRect list - removes any WindowRect that has widths and lengths of zero that will not be useful
	 */
	public void cleanUp() {
		for (int i = 0; i < rectlist.getLength(); i++){
			if (rectlist.get(i).getWidth() < 1 && rectlist.get(i).getHeight() < 1) {
				rectlist.remove(i);
			}
		}
	}
}
