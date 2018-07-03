package ru.yandex.sergaidm;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

public class PriceDescriptor implements CompositeUserType {

	@Override
	public String[] getPropertyNames() {
		return new String[] { "cost", "currency" };
	}

	@Override
	public Type[] getPropertyTypes() {
		return new Type[] { StandardBasicTypes.DOUBLE, StandardBasicTypes.STRING };
	}

	@Override
	public Object getPropertyValue(Object component, int property) throws HibernateException {
		Price price = (Price) component;
		switch (property) {
		case 0:
			return price.getCost();
		case 1:
			return price.getCurrency();
		default:
			throw new IllegalArgumentException("Invalid property number \"" + property + "\"");
		}
	}

	@Override
	public void setPropertyValue(Object component, int property, Object value) throws HibernateException {
		Price price = (Price) component;
		switch (property) {
		case 0:
			price.setCost((Double) value);
			break;
		case 1:
			price.setCurrency((String) value);
			break;
		default:
			throw new IllegalArgumentException("Invalid property number \"" + property + "\"");
		}
	}

	@Override
	public Class<Price> returnedClass() {
		return Price.class;
	}

	@Override
	public boolean equals(Object objectOne, Object objectTwo) throws HibernateException {
		if (null == objectOne || null == objectTwo) {
			return false;
		}
		return objectOne.equals(objectTwo);
	}

	@Override
	public int hashCode(Object object) throws HibernateException {
		return object.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object object)
			throws HibernateException, SQLException {
		Price price = new Price();
		price.setCost(rs.getDouble(names[0]));
		price.setCurrency(rs.getString(names[1]));
		return price;
	}

	@Override
	public void nullSafeSet(PreparedStatement ps, Object object, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		Price price = (Price) object;
		ps.setDouble(index + 0, price.getCost());
		ps.setString(index + 1, price.getCurrency());
	}

	@Override
	public Object deepCopy(Object object) throws HibernateException {
		Price price = (Price) object;
		return new Price(price.getCost(), price.getCurrency());
	}

	@Override
	public Object assemble(Serializable cached, SessionImplementor session, Object owner) throws HibernateException {
		return this.deepCopy(cached);
	}

	@Override
	public Serializable disassemble(Object object, SessionImplementor session) throws HibernateException {
		return (Serializable) this.deepCopy(object);
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Object replace(Object original, Object target, SessionImplementor session, Object owner)
			throws HibernateException {
		return this.deepCopy(original);
	}

}
