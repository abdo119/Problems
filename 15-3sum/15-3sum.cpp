class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        set<vector<int>> s;
        vector<vector<int>> ans;
        for(int i = 0; i < nums.size(); ++i)
        {
            if((i==0 || (i>0 and nums[i]!=nums[i-1])) and nums[i]<=0)//To remove the duplicate value
            for(int j = i+1; j < nums.size(); ++j)
            {
                if(j!=i+1 and nums[j]==nums[j-1])//To remove the duplicate value
                    continue;
                int sum = nums[i]+nums[j];
                auto it = lower_bound(nums.begin()+(j+1),nums.end(),-sum);//to find element after current element
                if(it!=nums.end() and nums[i]+nums[j]+*it==0)
                {
                        ans.push_back({nums[i],nums[j],-sum});
                }
            }
        }
        return ans;
    }
};