import java.util.ArrayList;
import java.util.List;

public class ResourceCollection<T> {

	private List<Result> items;
	
	public ResourceCollection() {
		this.items = new ArrayList<>();
	}
	
	public List<Result> getItems() {
		return items;
	}
	
	public void setItems(List<Result> items) {
		this.items = items;
	}
	
	public void addItem(Result result) {
		this.items.add(result);
	}
	
}
