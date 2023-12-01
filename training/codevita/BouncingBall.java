import java.util.Scanner;

class Ball {
    int x, y, dx, dy;

    public Ball(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }
}

public class BouncingBall {

    public static int stepsToOverlap(Ball b1, Ball b2) {
        for (int step = 0; step < 10000; step++) {
            if (b1.x == b2.x && b1.y == b2.y) {
                return step;
            }

            b1.x += b1.dx;
            b1.y += b1.dy;
            b2.x += b2.dx;
            b2.y += b2.dy;

            if ((b1.x <= 0 || b1.x >= 1000) || (b1.y <= 0 || b1.y >= 1000) ||
                (b2.x <= 0 || b2.x >= 1000) || (b2.y <= 0 || b2.y >= 1000)) {
                return -1; // Never overlaps
            }

            if (step > 0 && (b1.x == b1.dx || b1.x == 1000 - b1.dx)) b1.dx = -b1.dx;
            if (step > 0 && (b1.y == b1.dy || b1.y == 1000 - b1.dy)) b1.dy = -b1.dy;
            if (step > 0 && (b2.x == b2.dx || b2.x == 1000 - b2.dx)) b2.dx = -b2.dx;
            if (step > 0 && (b2.y == b2.dy || b2.y == 1000 - b2.dy)) b2.dy = -b2.dy;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M, N;
        M = scanner.nextInt();
        N = scanner.nextInt();

        Ball ball1 = new Ball(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        Ball ball2 = new Ball(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        int result = stepsToOverlap(ball1, ball2);

        if (result == -1) {
            System.out.println("Never");
        } else {
            System.out.println(result);
        }
    }
}
