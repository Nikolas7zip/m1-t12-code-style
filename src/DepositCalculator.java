import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateDepositAmount();
    }

    void calculateDepositAmount() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double resultDeposit = 0;
        if (action == 1) {
            resultDeposit = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            resultDeposit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultDeposit);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundWithPrecision(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundWithPrecision(pay, 2);
    }

    double roundWithPrecision(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
