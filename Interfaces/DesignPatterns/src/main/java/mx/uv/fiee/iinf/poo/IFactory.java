package mx.uv.fiee.iinf.poo;

/**
 * Factory abstraction to create any product
 * @param <T>
 */
public interface IFactory<T> {
    T create (String type);
}
