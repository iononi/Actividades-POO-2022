package mx.uv.fiee.iinf.poo;

public interface IFactory<T> {
    T create (String type);
}
