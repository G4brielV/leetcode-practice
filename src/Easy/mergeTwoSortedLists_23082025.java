package Easy;

public class mergeTwoSortedLists_23082025 {

    // https://leetcode.com/problems/merge-two-sorted-lists/

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        ListNode result = mergeTwoLists1(list1, list2);

        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        result.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }



    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next=mergeTwoLists2(list1.next,list2);
                return list1;
            }
            else{
                list2.next=mergeTwoLists2(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }



    }
}
