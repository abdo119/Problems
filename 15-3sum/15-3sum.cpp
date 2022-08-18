class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums)
    {
        vector<vector<int>>res;
        int n = nums.size();
        sort(nums.begin(),nums.end());
        // -4 -1 -1 0 1 2
        // -1 -1 2
        //-1 
        // -2 -1  0 1 2 3
        if(n<2)
        {
            return res;
        }
        for( int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                break;
            }
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            
            int l = i+1,r = n-1;
            while(l<r)
            {
                if(nums[i]+(nums[l]+nums[r])==0)
                {
                    res.push_back(vector<int>{nums[i],nums[l],nums[r]});
                    while(l<n-1 && nums[l]==nums[l+1])
                    {
                        l++;
                    }
                    while(r>0 && nums[r]==nums[r-1])
                    {
                        r--;
                    }
                    l++;
                    r--;
                }
                else if(nums[i] + (nums[l]+nums[r])>0)
                {
                    r--;
                }
                else
                {
                    l++;
                }
            }
        }
        return res;
        
    }
};