public class FloorAndCeil {
    public static void main(String[] args) {
        int [] a= new int[]{1, 2, 2, 3, 3, 5};
        int x=4;
        int l=0;
        int r=a.length-1;
        int floor=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]<=x){
                floor=a[mid];
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        l=0;
        r=a.length-1;
        int ceil=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]>=x){
                ceil=a[mid];
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        System.out.println(floor);
        System.out.println(ceil);
    }
}
