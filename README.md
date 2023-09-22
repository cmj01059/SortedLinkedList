Merge function
Make new list object O(1)
Insert each item of list 1 into list O(n) * O(n)
Insert each item of list 2 into list O(n) * O(n)
return list O(1)
O(n^2)

Delete alternating
temp =  head    1
for(list length) {      n
    if (count is even)  n
    delete(temp.info);  n/2 * n
    temp = temp.next    n
}
O(n^2)

Intersection
list = new list
temp = head
while (temp != null) {                  n
    if (temp.item exists in list)       
        insert item into list           n*n
    iterate
} 
loop through new list to print          n
O(n^2)