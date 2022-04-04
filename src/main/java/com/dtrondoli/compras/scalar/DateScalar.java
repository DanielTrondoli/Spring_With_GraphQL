package com.dtrondoli.compras.scalar;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.dtrondoli.compras.utils.DateUtils;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

@Component
public class DateScalar extends GraphQLScalarType {

	private static final String NAME = "Date";

	public DateScalar() {
		super(NAME, "Date type", new Coercing<Date, String>() {

			@Override
			public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
				if (dataFetcherResult instanceof Date) {
					return DateUtils.dateToString((Date) dataFetcherResult);
				}

				throw new CoercingSerializeException("Invalid Date: " + dataFetcherResult);
			}

			@Override
			public Date parseValue(Object input) throws CoercingParseValueException {
				if (input instanceof String) {
					Date d = DateUtils.stringToDate((String) input);
					if (d != null) {
						return d;
					}
				}
				throw new CoercingSerializeException("Invalid Date: " + input);
			}

			@Override
			public Date parseLiteral(Object input) throws CoercingParseLiteralException {
				if (!(input instanceof StringValue))
					return null;

				String s = ((StringValue) input).getValue();

				return this.parseValue(s);
			}
		});
	}
}
