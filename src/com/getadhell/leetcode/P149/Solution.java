package com.getadhell.leetcode.P149;

import java.util.*;


/**
 * https://leetcode.com/problems/max-points-on-a-line/description/
 */
public class Solution {
    private static int calculateGCD(int a, int b, int c) {
        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);
        int answer = 1;
        int d;
        if (a != 0) {
            d = a;
        } else if (b != 0) {
            d = b;
        } else if (c != 0) {
            d = c;
        } else {
            return 0;
        }
        while (d != 1) {
            if (a % d == 0 && b % d == 0 && c % d == 0) {
                a /= d;
                b /= d;
                c /= d;
                answer *= d;
            }
            d--;
        }
        return answer;
    }

    private static MyLine calculateLineCoeffs(Point A, Point B) {
        int a = (B.y - A.y);
        int b = -(B.x - A.x);
        int c = A.y * (B.x - A.x) - A.x * (B.y - A.y);

        if (a < 0) {
            a = -a;
            b = -b;
            c = -c;
        }
        int greatestDivisor = calculateGCD(a, b, c);
        if (greatestDivisor == 0) {
            return null;
        }
        a /= greatestDivisor;
        b /= greatestDivisor;
        c /= greatestDivisor;
        return new MyLine(a, b, c);
    }

    public static int maxPoints(Point[] points) {
        Set<MyLine> lines = new HashSet<>();
        Map<String, Integer> pointSet = new HashMap<String, Integer>();
        int pointMax = 0;
        for (int i = 0; i < points.length; i++) {
            String pointHash = points[i].x + "" + points[i].y;
            if (!pointSet.containsKey(pointHash)) {
                pointSet.put(pointHash, 1);
                pointMax = 1;
            } else {
                int numsofp = pointSet.get(pointHash) + 1;
                pointSet.put(pointHash, numsofp);
                if (numsofp > pointMax) {
                    pointMax = numsofp;
                }
            }
            for (int j = i + 1; j < points.length; j++) {
                MyLine myLine = calculateLineCoeffs(points[i], points[j]);
                if (myLine == null) {
                    continue;
                }
                lines.add(myLine);
            }
        }
        if (lines.size() == 0) {
            System.out.println("No lines");
            return pointMax;
        }
        int max = 0;
        for (MyLine line : lines) {
            int tempMax = 0;
            for (int i = 0; i < points.length; i++) {
                if (line.isOn(points[i])) {
                    tempMax++;
                }
            }
            if (tempMax > max) {
                max = tempMax;
            }
        }
        if (pointMax > max) {
            System.out.println("pointmax");
            return pointMax;
        }
        return max;
    }

    private static class MyLine {
        public int a;
        public int b;
        public int c;

        public MyLine(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isOn(Point point) {
            return (long) this.a * (long) point.x + (long) this.b * (long) point.y + this.c == 0;
        }

        @Override
        public boolean equals(Object obj) {
            MyLine line2 = (MyLine) obj;
            if (line2.a == this.a
                    && line2.b == this.b
                    && line2.c == this.c) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}