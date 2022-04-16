class Solution {
    public Node flatten(Node head) {
        Stack<Node> st = new Stack<>();
        Node curr = head;
        while(curr != null)
        {
            if(curr.child != null)
            {
                if(curr.next != null)
                    st.push(curr.next);
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            }
            if(curr.next == null && !st.isEmpty())
            {
                Node a = st.pop();
                curr.next = a;
                a.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
