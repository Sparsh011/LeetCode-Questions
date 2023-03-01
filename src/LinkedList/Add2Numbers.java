package LinkedList;

public class Add2Numbers {
//    Input: l1 = [2,4,3], l2 = [5,6,4]
//    Output: [7,0,8]

    public SingleListNote addTwoNumbers(SingleListNote l1, SingleListNote l2) {
        SingleListNote res = new SingleListNote(-1);
        int carry = 0;
        SingleListNote nextForRes = res;
        SingleListNote temp1 = l1, temp2 = l2;

        while(temp1 != null || temp2 != null){
            int num1 = temp1 == null ? 0 : temp1.val;
            int num2 = temp2 == null ? 0 : temp2.val;
            int sum = num1 + num2 + carry;

            carry = sum / 10;
            int newSum = sum % 10;

            SingleListNote nextNode = new SingleListNote(newSum);
            nextForRes.next = nextNode;
            nextForRes = nextForRes.next;

            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }

        if(carry != 0){
            SingleListNote nextNode = new SingleListNote(carry);
            nextForRes.next = nextNode;
        }

        return res.next;
    }
}
