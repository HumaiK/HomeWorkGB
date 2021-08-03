package ru.gb.lesson1;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static char[][] map;
    public static char[][] invisibleMap;
    public static int mapWidth;
    public static int mapHeight;
    public static int mapSizeMin = 3;
    public static int mapSizeMax = 5;
    public static int mapCountLevel = 0;

    public static char player = '@';
    public static int playerHealth = 100;
    public static int playerPowerPoint = 15;
    public static int playerPosX;
    public static int playerPosY;
    public static int playerCountStep = 0;
    public static boolean setRandomStartPosition = false;

    public static final int moveUp = 8;
    public static final int moveDown = 2;
    public static final int moveLeft = 4;
    public static final int moveRight = 6;
    public static final int moveLeftUpRightDownDiag = 7;
    public static final int moveRightDownLeftUpDiag = 3;
    public static final int moveLeftDownRightUpDiag = 1;
    public static final int moveRightUpLeftDownDiag = 9;

    public static char enemy = 'E';
    public static int enemyHealth;
    public static int enemyPower;
    public static int enemyValueMin = 10;
    public static int enemyValueMax = 30;

    public static char readyCell = '*';
    public static char emptyCell = '_';

    public static void main(String[] args) {   //1. Проверяем isPlayerAlive, если true, то выводим сообщение о начале игры с указанием уровня mapCountLevel. (59-71)

        while (isPlayerAlive()) {
            ++mapCountLevel;
            System.out.println("===== Game Start! Current LEVEL " + mapCountLevel);
            gameCycle();
        }
        System.out.println("===== Game Over! Count player steps: " + playerCountStep + ". Count ready level " + mapCountLevel);
    }

    public static void gameCycle() {  // 2. Создаем 2 одинаковые карты (одна из них невидна пользователю) с рандомной высотой и шириной в пределах range. (76-86)
        createMap();                  // И сообщаем пользователю о том, что карта создалась + ее размер. (88)
        createPlayer(setRandomStartPosition); // 3. Создаем игрока с позицией на карте. (Контролируем в методе setRandomStartPosition - посередине или рандомно.) (102-111)
        createEnemies();              // 4. Создаем врагов с рандомной позицией (не должна совпадать с позицией игрока (130-133). Присуждаем им рандомное enemyHealth enemyPower с учетом границ enemyValue. (113-133)
                                      // Количество врагов контролируется countEnemies. (120)
        while (true) {
            printMap();
            System.out.println("[Player info] > Health: " + playerHealth + ". Count steps: " + playerCountStep);
            changePositionPlayer();

            if (!isPlayerAlive()) {
                System.out.println("Player is Dead!");
                break;
            }

            if (isFullMap()) {
                System.out.println("Map is full");
                break;
            }
        }
    }

    public static void createMap() {
        mapHeight = randomRange(mapSizeMin, mapSizeMax);
        mapWidth = randomRange(mapSizeMin, mapSizeMax);
        map = new char[mapHeight][mapWidth];
        invisibleMap = new char[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = emptyCell;
            }
        }

        System.out.println("Create map > size " + mapWidth + "x" + mapHeight);
    }

    public static void printMap() {               // 5. Отображаем уже созданную ранее видимую карту пользователю. Позиция игрока тоже будет сразу учтена.
        System.out.println("===== CURRENT MAP =====");
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }

    public static void createPlayer(boolean randomPositionPlayer) {
        if (randomPositionPlayer) {
            playerPosX = randomRange(0, mapWidth - 1);
            playerPosY = randomRange(0, mapHeight - 1);
        } else {
            playerPosX = mapWidth / 2;
            playerPosY = mapHeight / 2;
        }
        map[playerPosY][playerPosX] = player;
    }

    public static void createEnemies() {
        enemyHealth = randomRange(enemyValueMin, enemyValueMax);
        enemyPower = randomRange(enemyValueMin, enemyValueMax);

        int posX;
        int posY;

        int countEnemies = (mapWidth + mapHeight) / 4;

        for (int i = 0; i < countEnemies; i++) {

            do {
                posX = random.nextInt(mapWidth);
                posY = random.nextInt(mapHeight);
            } while (posX == playerPosX && posY == playerPosY);

            invisibleMap[posY][posX] = enemy;
        }
        System.out.println("Enemy count: " + countEnemies + ". Enemy power: " + enemyPower + ". Enemy health: " + enemyHealth);
    }

    public static void changePositionPlayer() {   // 6. Ход за  игроком: ввод с консоли (150). Изменение позиции игрока @ cогласно введенным пользователем данным. (152-180)
        int currentX = playerPosX;                // Далее несколько вариантов развития: а. успешный переход без столкновения с enemy. ( (188-191)
        int currentY = playerPosY;                // б. успешный переход,  но столкновение с enemy - уменьшение жизни игрока.  (200-203)
                                                  // в.  неверный ход (за пределы карты) (192-196).
        int playerMove;                           // В случаях а-б "ячейка" меняется на readyCell. (206,207), увеличиваем счетчик playerCountStep.

        do {
            System.out.print("Enter your move (UP=" + moveUp +
                    " DOWN=" + moveDown +
                    " LEFT=" + moveLeft +
                    " RIGHT=" + moveRight +
                    " LDRU=" + moveLeftDownRightUpDiag +
                    " RULD=" + moveRightUpLeftDownDiag +
                    " LURD=" + moveLeftUpRightDownDiag +
                    " RDLU=" + moveRightDownLeftUpDiag + ") >>> "
            );
            playerMove = scanner.nextInt();

            switch (playerMove) {
                case moveUp:
                    playerPosY -= 1;
                    break;
                case moveDown:
                    playerPosY += 1;
                    break;
                case moveLeft:
                    playerPosX -= 1;
                    break;
                case moveRight:
                    playerPosX += 1;
                    break;
                case moveLeftDownRightUpDiag:
                    playerPosX -= 1;
                    playerPosY += 1;
                    break;
                case moveRightUpLeftDownDiag:
                    playerPosX += 1;
                    playerPosY -= 1;
                    break;
                case moveRightDownLeftUpDiag:
                    playerPosX += 1;
                    playerPosY += 1;
                    break;
                case moveLeftUpRightDownDiag:
                    playerPosX -= 1;
                    playerPosY -= 1;
                    break;
            }
        } while (!isValidNextMove(currentY, currentX, playerPosY, playerPosX));

        playerNextMoveAction(currentY, currentX, playerPosY, playerPosX);
        ++playerCountStep;
    }

    public static boolean isValidNextMove(int currentY, int currentX, int nextY, int nextX) {
        if (nextY >= 0 && nextY < mapHeight && nextX >= 0 && nextX < mapWidth) {
            System.out.println("Player move to [" + (nextX + 1) + ":" + (nextY + 1) + "]  success");
            return true;
        } else {
            playerPosX = currentX;
            playerPosY = currentY;
            System.out.println("Invalid move. Please try again");
            return false;
        }
    }

    public static void playerNextMoveAction(int currentY, int currentX, int nextY, int nextX) {
        if (invisibleMap[nextY][nextX] == enemy) {
            playerHealth -= enemyPower;
            System.out.println("Alert! Enemy give damage " + enemyPower + ". Player health now is " + playerHealth);
        }

        invisibleMap[playerPosY][playerPosX] = readyCell;
        map[currentY][currentX] = readyCell;
        map[playerPosY][playerPosX] = player;
    }

    public static int randomRange(int min, int max) {
        int diff = max - min;
        int value = random.nextInt(diff + 1);
        return min + value;
    }

    public static boolean isFullMap() {                   // При соблюдении условий  isFullMap создается новая карта, увеличивается mapCountLevel.
        for (int y = 0; y < mapHeight; y++) {             // Далее весь предыдущий цикл повторяется.
            for (int x = 0; x < mapWidth; x++) {
                if (map[y][x] == emptyCell) return false;
            }
        }
        return true;
    }

    public static boolean isPlayerAlive() {   // Игра продолжается до тех пор, пока playerHealth > 0.
        return playerHealth > 0;
        }
}
