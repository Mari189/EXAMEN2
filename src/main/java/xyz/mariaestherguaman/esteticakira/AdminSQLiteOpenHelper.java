package xyz.mariaestherguaman.esteticakira;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**  * Created by maria on 21/02/2021//
 *
  */
public class AdminSQLiteOpenHelper  extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table articulos(codigo int primary key,descripcion text,precio real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        TextView de tipo "Number" (ID="txt_codigo", hint="Ingrese codigo")
        TextView de tipo "Plain Text" (ID="txt_precio", hint="Ingrese precio")
        Button (ID="btn_ingresar", text="guardar cursos", onClick="guardarcursos")
        Button (ID="btn_registrar", text="registrar producto", onClick="registrarproducto")
        Button (ID="btn_modificar", text="modificar", onClick="modificar")
        Button (ID="btn_borrar", text="borrar", onClick="borrar")
        Button (ID="btn_consultar", text="consultar", onClick="consultar")
    }
}

