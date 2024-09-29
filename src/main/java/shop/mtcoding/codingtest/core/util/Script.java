package shop.mtcoding.codingtest.core.util;

public class Script {

    public static String back(String msg) {
        String errMsg = """
                <script>
                    alert('$msg');
                    history.back();
                </script>
                """.replace("$msg", msg);
        return errMsg;
    }
}
