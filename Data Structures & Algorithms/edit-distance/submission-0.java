class Solution {
    public int minDistance(String word1, String word2) {
        // we create our dp table
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // we will fill in our base cases
        for(int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
        for(int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;

        for(int i = 1; i < word1.length() + 1; i++){
            for(int j = 1; j < word2.length() + 1; j++){
                // we have the same character at the indeces, we don't need an operation
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                // if they are not the same, we will use an operation and take the minimum number of operations needed
                else{
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}

/*
We are given two strings

We are asked to return an integer

Description:

We are given two strings 

We are allowed to perform three operations on the first string an unlimited amount of time

The operations are:

Insert a character at any position

Delete a character at any position

Replace a character at any position

We will return the minimum number of operations to make the first string equal to the second one

Example:

Input: word1 = "monkeys", word2 = "money"

So to get to money from monkeys

We can delete the s at the end

we have monkey now

We can delete k

Now we have money

So we will return 2

An approach:

We will have a 2D dp table

Where dp[i][j] is the minimum number of operations needed to convert the characters up to i from the first string to the characters up to j from the second string

We will set dp[i][0] as i where we will delete all the characters in the first string to get an empty string, we would need i deletions

We set dp[0][j] as j as we convert an empty string to the second string, we would need j insertions

If the characters at i and j are equal, there is no need for an operation (dp[i][j] = dp[i-1][j-1])

If they are not equal, we can do 1 of the 3 operations:

Insert (dp[i][j-1] + 1)
Delete (dp[i-1][j] + 1)
Replace (dp[i-1][j-1] + 1)

Our answer is then in the cell dp[word1.length()][word2.length()]

Another Approach:

We will have two indeces, one pointing at the first string and one at the second string

if the indeces are equal in each string, we increment each index

if they are not equal, we will do an operation

Insert in string 1 and increment index in string 2, so 1 + (i, j + 1)

Delete in string 1 and increment index in string 1, so 1 + (i + 1, j)

Replace in string 1 and increment both indeces, so 1 + (i + 1, j + 1) 

If we have two empty strings, we return 0 as they are equal

We can use 2D dp table

each cell is the minimum number of operations for each characater up till each index to match
*/