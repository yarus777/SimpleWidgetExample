import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;


public class SimpleWidgetAppWidgetProvider extends AppWidgetProvider{
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		final int N = appWidgetIds.length;
		ComponentName thisWidget = new ComponentName(context, SimpleWidgetAppWidgetProvider.class);
		int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
		
		//Crear el servicio
		Intent intent = new Intent(context.getApplicationContext(), UpdateWidgetService.class);
		intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);
		
		//Iniciar los widgets a travez del servicio
		context.startService(intent);
	}
}
