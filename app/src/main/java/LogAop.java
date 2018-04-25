import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Description :
 *
 * @author XQ Yang
 * @date 2018/4/23  20:12
 */
@Aspect
public class LogAop {
    private static final String TAG = "LogAop";
    @Pointcut("execution(* *..*Activity.on*(..))")
    public void logOnActivity(){}

    @Before("logOnActivity()")
    public void log(JoinPoint point) {
        Log.e(TAG,"log: "+point.toShortString());
    }

}
