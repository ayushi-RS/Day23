class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> oldToNewMap = new HashMap();
        
        Node newHead = new Node(head.val);
        Node np = newHead;
        Node p = head;
        oldToNewMap.put(head, newHead);
        
        while(p != null) {
            Node pNext = p.next;
            Node pRandom = p.random;
            
            if(pNext != null) {
                Node npNext = new Node(pNext.val);
                if(oldToNewMap.containsKey(pNext)) {
                    npNext = oldToNewMap.get(pNext);
                }
                oldToNewMap.put(pNext, npNext);
                np.next = npNext;
            }
            
            if(pRandom != null) {
                Node npRandom = new Node(pRandom.val);
                if(oldToNewMap.containsKey(pRandom)) {
                    npRandom = oldToNewMap.get(pRandom);
                }
                oldToNewMap.put(pRandom, npRandom);
                np.random = npRandom;
            }
            
            np = np.next;
            p = p.next;
        }
        
        return newHead;
    }
}