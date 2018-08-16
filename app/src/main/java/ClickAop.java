import android.util.Log;
import android.view.View;
import com.longforus.aopdemo.OneClick;
import com.longforus.aopdemo.R;
import java.util.Calendar;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Description :
 *
 * @author XQ Yang
 * @date 8/16/2018  3:49 PM
 */
@Aspect
public class ClickAop {

    private final static int TIME_TAG = R.id.oneClick_tag;

    @Pointcut("execution(@com.longforus.aopdemo.OneClick * *(..))")
    public void onClick() {
    }

    @Around("onClick()")
    public void onRealClick(ProceedingJoinPoint point) throws Throwable {
        View view = null;
        for (Object arg : point.getArgs()) {
            if (arg instanceof View) {
                view = (View)arg;
            }
        }
        if (view != null) {
            OneClick oneClick = AspectJUtil.getMethodAnnotation(point,OneClick.class);
            Object tag = view.getTag(TIME_TAG);
            long lastClickTime = ((tag != null) ? (long)tag : 0);
            Log.d("SingleClickAspect","lastClickTime:" + lastClickTime);
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (currentTime - lastClickTime > oneClick.value()) {
                view.setTag(TIME_TAG,currentTime);
                Log.d("SingleClickAspect","currentTime:" + currentTime);
                point.proceed();//执行原方法
            }
        }
    }
}
