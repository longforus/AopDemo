import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Description : 只有java代码有效,kotlin的话不知道使用注解的方式有没有效果,
 * 本类中没有override的方法无效
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
