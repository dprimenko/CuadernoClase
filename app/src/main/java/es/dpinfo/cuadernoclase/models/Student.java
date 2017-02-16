package es.dpinfo.cuadernoclase.models;

/**
 * Created by dprimenko on 16/02/17.
 */
public class Student {

    private int mId;
    private String mNombre;
    private String mApellidos;
    private String mDireccion;
    private String mCiudad;
    private String mCp;
    private String mTelefono;
    private String mEmail;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmNombre() {
        return mNombre;
    }

    public void setmNombre(String mNombre) {
        this.mNombre = mNombre;
    }

    public String getmApellidos() {
        return mApellidos;
    }

    public void setmApellidos(String mApellidos) {
        this.mApellidos = mApellidos;
    }

    public String getmDireccion() {
        return mDireccion;
    }

    public void setmDireccion(String mDireccion) {
        this.mDireccion = mDireccion;
    }

    public String getmCiudad() {
        return mCiudad;
    }

    public void setmCiudad(String mCiudad) {
        this.mCiudad = mCiudad;
    }

    public String getmCp() {
        return mCp;
    }

    public void setmCp(String mCp) {
        this.mCp = mCp;
    }

    public String getmTelefono() {
        return mTelefono;
    }

    public void setmTelefono(String mTelefono) {
        this.mTelefono = mTelefono;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "mId=" + mId +
                ", mNombre='" + mNombre + '\'' +
                ", mApellidos='" + mApellidos + '\'' +
                ", mDireccion='" + mDireccion + '\'' +
                ", mCiudad='" + mCiudad + '\'' +
                ", mCp='" + mCp + '\'' +
                ", mTelefono='" + mTelefono + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }
}
