package xyz.mariaestherguaman.esteticakira;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class CursoActivity extends AppCompatActivity {
    private TextView txt_producto, txt_precio;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        txt_producto = (TextView)findViewById(R.id.txt_producto)
        txt_precio = (TextView)findViewById(R.id.txt_precio)
    }

    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new
                AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = txt_producto.getText().toString();
        String descri = txt_precio.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("producto", prod);
        registro.put("precio", pre);
        bd.insert("productos", null, registro);
        bd.close();
        txt_producto.setText("");
        txt_precio.setText("");

        Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();
    }
    public void consultaporcodigo(View v) {
    AdminSQLiteOpenHelper admin = new
            AdminSQLiteOpenHelper(this,

            "administracion", null, 1);
    SQLiteDatabase bd = admin.getWritableDatabase();
    String cod = et1.getText().toString();
    Cursor fila = bd.rawQuery(
            "select descripcion,precio from articulos where codigo=" + cod, null);
    if (fila.moveToFirst()) {
        txt_producto.setText(fila.getString(0));
        txt_precio.setText(fila.getString(1));
    } else
        Toast.makeText(this, "No existe un artículo con dicho código",
                Toast.LENGTH_SHORT).show();
    bd.close();     }

    public void consultapordescripcion(View v) {
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
            "administracion", null, 1);
    SQLiteDatabase bd = admin.getWritableDatabase();
    String descri = txt_precio.getText().toString();
    Cursor fila = bd.rawQuery(
            "select codigo,precio from articulos where descripcion='" + descri +"'", null);
    if (fila.moveToFirst()) {
        txt_producto.setText(fila.getString(0));
        txt_precio.setText(fila.getString(1));
    } else
        Toast.makeText(this, "No existe un artículo con dicha descripción",
                Toast.LENGTH_SHORT).show();
    bd.close();     }

    public void bajaporcodigo(View v) {
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
            "administracion", null, 1);
    SQLiteDatabase bd = admin.getWritableDatabase();
    String cod= txt_producto.getText().toString();
    int cant = bd.delete("articulos", "codigo=" + cod, null);
    bd.close();
    txt_producto.setText("");
    txt_precio.setText("");

    if (cant == 1)
        Toast.makeText(this, "Se borró el artículo con dicho código",
                Toast.LENGTH_SHORT).show();
    else
        Toast.makeText(this, "No existe un artículo con dicho código",
                Toast.LENGTH_SHORT).show();     }

    public void modificacion(View v) {
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
            "administracion", null, 1);
    SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = txt_producto.getText().toString();
        String descri = txt_precio.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        int cant = bd.update("articulos", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "no existe un artículo con el código ingresado",
                    Toast.LENGTH_SHORT).show();     }
}


private void LimpiarTextos()
    {
        txt_producto.setText("");
        txt_precio.setText("");

    }

   private boolean existeFile(String[] productos, String producto)
   {
       for(int f=0

        blic void consultaporcodigo(View v) {
           AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
        "administracion", null, 1);
           SQLiteDatabase bd = admin.getWritableDatabase();
           String cod = txt_producto.getText().toString();
           Cursor fila = bd.rawQuery(
                   "select descripcion,precio from articulos where codigo=" + cod, null);
           if (fila.moveToFirst()) {
               txt_producto.setText(fila.getString(0));
               txt-precio.setText(fila.getString(1));
           } else
               Toast.makeText(this, "No existe un artículo con dicho código",
        Toast.LENGTH_SHORT).show();
           bd.close();     }

        try{
        SqLiteDatabase bd = openOrCreateDatabase("BaseKira",MODE_PRIVATE, null);
        // creando la tabla
        String sql = "CREATE TABLE IF NOT EXIST producto(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR, stock INTEGER)";
        bd.execSQL(sql);
        // insertando la tabla
        bd.execSQL("INSERT INTO producto(nombre, stok) VALUES('TALCO ANTIPULGAS',25)");
        bd.execSQL("INSERT INTO producto(nombre, stok) VALUES('JABON ANTIPULGAS',25)");
        bd.execSQL("INSERT INTO producto(nombre, stok) VALUES('ANTIDESPASITANTES',25)");
        bd.execSQL("INSERT INTO producto(nombre, stok) VALUES('SHAMPOO',25)");
        bd.execSQL("INSERT INTO producto(nombre, stok) VALUES('COLLARES',25)");
        bd.execSQL("INSERT INTO producto(nombre, stok) VALUES('CAMAS',25)");
        bd.execSQL("INSERT INTO producto(nombre, stok) VALUES('JAULAS',25)");
        bd.execSQL("INSERT INTO producto(nombre, stok) VALUES('JUGUETES',25)");

        Cursor cursor = bd.rawQuery("SELECT nombre, stock FROM productoQ", null);
        if (cursor.moveToFirst()){
            String datos ="";
            while(cursor !=null){
                datos ="ID: " + cursor.geInt(0) + "Producto:" + cursor.getString(1) + "Stock:" + cursor.getInt(2);
                Log.i("SQLiteKira", datos);
                cursor.moveToNext();

            }

        }else{
            Toast.makeText(this, "NO EXISTEN REGISTROS DE PRODUCTO",Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            e.printStackTrace();
            }



    }
}