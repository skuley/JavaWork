class Exercise {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] answer = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];
        

        System.out.println(sol.solution(answer, commands).toArray());
        
    }

    class Solution {
        public int[] solution (int[] array, int[][] commands){

            for(int i = 1; i <= 3; i++){
                for(int j = 1; j <=3; j++){
                    array = new int[commands[i].length];
                }
            }

            int[] answer = {1, 2, 3};
            return answer;
        }
    } // Solution{}
} // Exercise{}