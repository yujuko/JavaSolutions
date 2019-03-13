/*
 733. Flood Fill

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */


//solution using stack: 8ms beats 82.12% 
class Solution {
    public class Point{
        private int x;
        private int y;
        Point(int x ,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        Point root = new Point(sr,sc);
        Point point = null;
        LinkedList<Point> stack = new LinkedList<>();
        int oldColor = image[sr][sc];
        stack.push(root);
        while(!stack.isEmpty()){
            point = stack.pop();
            if(point.x>=1 && image[point.x-1][point.y]==oldColor)
                stack.push(new Point(point.x-1,point.y));
            if(point.y>=1 && image[point.x][point.y-1]==oldColor)
                stack.push(new Point(point.x,point.y-1));
            if(point.x+1< image.length && image[point.x+1][point.y]==oldColor)
                stack.push(new Point(point.x+1,point.y)); 
            if(point.y+1< image[sr].length && image[point.x][point.y+1]==oldColor)
                stack.push(new Point(point.x,point.y+1)); 
            image[point.x][point.y]= newColor;                        
        }

        return image;
    }
}

//solution using recursion: 7ms beats 100%
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) 
            return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
