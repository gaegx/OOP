//TIP Для <b>запуска</b> кода нажмите <shortcut actionId="Run"/> или
// щелкните значок <icon src="AllIcons.Actions.Execute"/> в боковой области.
public class Main {
    public static void main(String[] args) {
        //TIP Нажмите <shortcut actionId="ShowIntentionActions"/>, поместив каретку на выделенный текст
        // чтобы увидеть, как IntelliJ IDEA предлагает исправить это.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Нажмите <shortcut actionId="Debug"/>, чтобы начать отладку кода. Мы установили одну <icon src="AllIcons.Debugger.Db_set_breakpoint"/> точку останова
            // для вас, но вы всегда можете добавить еще, нажав <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}