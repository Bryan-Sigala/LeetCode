class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length, actualIndex = 0;
        int[] diff = new int[n];

        do{
            int[] prefix = new int[actualIndex+1];
            int[] suffix = new int[n-actualIndex-1];

            // Prefix count
            if(actualIndex == 0){
                if(nums[0] > 0)
                    prefix[0] = nums[0];
            } else {
                for(int i=0; i <= actualIndex; i++){
                    boolean isDistinct = true;
                    for(int j=0; j <= actualIndex; j++)
                        if(nums[i] == prefix[j]){
                            isDistinct = false;
                            break;
                        }
                    if(isDistinct)
                        prefix[i] = nums[i];
                }
            }

            // Suffix count
            int suffixCount = 0;
            if(actualIndex == n-2){
                if(nums[n-1] > 0)
                    suffix[0] = nums[n-1];
            } else {
                for(int i=actualIndex+1; i < n; i++){
                    boolean isDistinct = true;
                    for(int j=0; j < n-actualIndex-1; j++)
                        if(nums[i] == suffix[j]){
                            isDistinct = false;
                            break;
                        }
                    if(isDistinct){
                        suffix[suffixCount] = nums[i];
                        suffixCount++;
                    }
                }
            }

            //Finding the Distinct Difference
            int pCount = 0, sCount = 0;
            for(int i=0; i < prefix.length; i++)
                if(prefix[i] > 0)
                    pCount++;

            for(int i=0; i < suffix.length; i++)
                if(suffix[i] > 0)
                    sCount++;
            
            diff[actualIndex] = pCount - sCount;

            actualIndex++;
        }while(actualIndex < n);
        

        return diff;
    }
}