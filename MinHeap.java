import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Edge> heap;
    
    public MinHeap() {
        heap = new ArrayList<Edge>();
    }
    
    public boolean empty() {
        return (heap.size() == 0);
    }
    
    public void push(Edge e) {
        heap.add(e);
        if (heap.size() == 1) {
            return;
    }
    //Heapify_Up
    int index = heap.size() - 1;
    int parentIndex = (index - 1) / 2;
    //If the nodes are in correct location or index, algorithms will break or stop
    while (parentIndex > 0) {
        if (heap.get(parentIndex).getWeight() <= heap.get(index).getWeight()) {
            break;
        }
        //Set the new index which is changed between parent and child (priority queue)
        Edge temp = heap.get(parentIndex);
        heap.set(parentIndex, heap.get(index));
        heap.set(index, temp);
        
        index = parentIndex;
        parentIndex = (index - 1) / 2;
    }
    	//again we set the new index which is changed between parent and child, since we need 
    	//to check upper level parent (priority queue)
        if (heap.get(parentIndex).getWeight() > heap.get(index).getWeight()) {
            Edge temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(index));
            heap.set(index, temp);
        }
    }
    //if we face to any empty edge we return null
	public Edge pop() {
        if (empty()) {
            return null;
        }
        
        Edge minWeightEdge = heap.get(0);
        
        // Heapify_down
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        if (heap.size() != 0) {
            int index = 0, leftIndex = 1, rightIndex = 2;
            while (rightIndex < heap.size()) {
                if ((heap.get(index).getWeight() <= heap.get(leftIndex).getWeight()) && (heap.get(index).getWeight() <= heap.get(rightIndex).getWeight())) {
                    break;
                }
                // Because the algorithms is min-heap priority queue, the index of the node at left should be bigger than value of the node at right
                if (heap.get(leftIndex).getWeight() <= heap.get(rightIndex).getWeight()) {
                    //Exchange the location of left child with right child
                    Edge temp = heap.get(index);
                    heap.set(index, heap.get(leftIndex));
                    heap.set(leftIndex, temp);
                    index = leftIndex;
                }
                else {
                    //Set the location of the nodes which are in correct location
                    Edge temp = heap.get(index);
                    heap.set(index, heap.get(rightIndex));
                    heap.set(rightIndex, temp);
                    index = rightIndex;
                }
                
                leftIndex = (2 * index) + 1;
                rightIndex = (2 * index) + 2;
            }
            //Exchange the location of the parent node with left child, if the left child is smaller than the parent
            //Because in min-heap priority queue, nodes set from small to bigger
            if (leftIndex < heap.size()) {
                if (heap.get(index).getWeight() > heap.get(leftIndex).getWeight()) {
                    Edge temp = heap.get(index);
                    heap.set(index, heap.get(leftIndex));
                    heap.set(leftIndex, temp);
                }
            }
        }
        //min-heap priority que is a recursive algorithm
        return minWeightEdge;
    }
    
}