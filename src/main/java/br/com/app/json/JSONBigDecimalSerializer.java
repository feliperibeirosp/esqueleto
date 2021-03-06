package br.com.app.json;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JSONBigDecimalSerializer extends JsonSerializer<BigDecimal> {

	
	@Override
	public void serialize(BigDecimal value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException, JsonProcessingException {
		
		if ( value != null ){
			
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setGroupingSeparator('.');
			symbols.setDecimalSeparator(',');
			String pattern = "###,##0.0#";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
			decimalFormat.setParseBigDecimal(true);

			String valueAsText = decimalFormat.format( value ); 
			
			jsonGenerator.writeString(valueAsText);
		}
	}
}
