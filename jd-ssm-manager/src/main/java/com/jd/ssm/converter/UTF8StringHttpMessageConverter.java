package com.jd.ssm.converter;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class UTF8StringHttpMessageConverter extends StringHttpMessageConverter {

	private static final MediaType utf8 = new MediaType("text", "plain",Charset.forName("UTF-8"));
	private boolean writeAcceptCharset = true;

	@Override
	protected Long getContentLength(String s, MediaType contentType) {
		Charset charset = getContentTypeCharset(contentType);
		try {
			return (long) s.getBytes(charset.name()).length;
		}
		catch (UnsupportedEncodingException ex) {
			throw new InternalError(ex.getMessage());
		}
	}
	
	@Override
	protected MediaType getDefaultContentType(String dumy) {
		return utf8;
	}
	@Override
	protected List<Charset> getAcceptedCharsets() {
		return Arrays.asList(utf8.getCharSet());
	}
	@Override
	protected void writeInternal(String s, HttpOutputMessage outputMessage)
			throws IOException {
		if (this.writeAcceptCharset) {
			outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
		}
		Charset charset = utf8.getCharSet();
		FileCopyUtils.copy(s, new OutputStreamWriter(outputMessage.getBody(), charset));
	}
	public boolean isWriteAcceptCharset() {
		return writeAcceptCharset;
	}
	public void setWriteAcceptCharset(boolean writeAcceptCharset) {
		this.writeAcceptCharset = writeAcceptCharset;
	}
	private Charset getContentTypeCharset(MediaType contentType) {
		if (contentType != null && contentType.getCharSet() != null) {
			return contentType.getCharSet();
		}
		else {
			return utf8.getCharSet();
		}
	}
}
