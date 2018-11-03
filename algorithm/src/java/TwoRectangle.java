public class TwoRectangle {

    public static void main(String[] args) {

        Rect r1 = new Rect(new Point(1,1), new Point(3,3));

        Rect r2 = new Rect(new Point(1,1), new Point(5,5));

        r1.getS(r2);

    }

    public static class Point{

        private int x;

        private int y;

        public int getX() {

            return x;

        }

        public void setX(int x) {

            this.x = x;

        }

        public int getY() {

            return y;

        }

        public void setY(int y) {

            this.y = y;

        }

        public Point() { }

        public Point(int x, int y) {

            this.x = x;

            this.y = y;

        }

    }

    public static class Rect extends Point{

        Point p1;

        Point p2;



        public Point getP1() {

            return p1;

        }



        public void setP1(Point p1) {

            this.p1 = p1;

        }



        public Point getP2() {

            return p2;

        }



        public void setP2(Point p2) {

            this.p2 = p2;

        }



        public Rect(Point p1, Point p2) {

            this.p1 = p1;

            this.p2 = p2;

        }



        public void getS(/*this*/ Rect r1){

            //先找出每个矩形的最小x,然后再取两个最小x值中的较大值

            int minX = Math.max(Math.min(this.getP1().getX(), this.getP2().getX()),

                    Math.min(r1.getP1().getX(), r1.getP2().getX()));

            //先找出每个矩形的最小y,然后再取两个最小y值中的较大值

            int minY = Math.max(Math.min(this.getP1().getY(), this.getP2().getY()),

                    Math.min(r1.getP1().getY(), r1.getP2().getY()));

            //先找出每个矩形的最大x,然后再取两个最大x值中的较小值

            int maxX = Math.min(Math.max(this.getP1().getX(), this.getP2().getX()),

                    Math.max(r1.getP1().getX(), r1.getP2().getX()));

            //先找出每个矩形的最大y,然后再取两个最大y值中的较小值

            int maxY = Math.min(Math.max(this.getP1().getY(), this.getP2().getY()),

                    Math.max(r1.getP1().getY(), r1.getP2().getY()));

            if (minX < maxX && minY < maxY){

                System.out.println(Math.round((maxX - minX) * (maxY - minY)*100)/100.00);

            }else{

                System.out.println(0.00);

            }

        }

    }

}
