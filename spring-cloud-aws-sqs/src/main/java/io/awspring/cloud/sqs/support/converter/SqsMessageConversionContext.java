/*
 * Copyright 2013-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.awspring.cloud.sqs.support.converter;

import io.awspring.cloud.sqs.listener.QueueAttributes;
import io.awspring.cloud.sqs.listener.QueueAttributesAware;
import io.awspring.cloud.sqs.listener.SqsAsyncClientAware;
import io.awspring.cloud.sqs.listener.acknowledgement.AcknowledgementCallback;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

/**
 * {@link MessageConversionContext} implementation that contains SQS related properties for mapping additional
 * {@link org.springframework.messaging.MessageHeaders}. Also contains a {@link AcknowledgementCallback} to be used for
 * mapping acknowledgement related headers.
 * @author Tomaz Fernandes
 * @since 3.0
 * @see SqsHeaderMapper
 * @see SqsMessagingMessageConverter
 */
public class SqsMessageConversionContext
		implements AcknowledgementAwareMessageConversionContext, SqsAsyncClientAware, QueueAttributesAware {

	private QueueAttributes queueAttributes;

	private SqsAsyncClient sqsAsyncClient;

	private AcknowledgementCallback<?> acknowledgementCallback;

	@Override
	public void setQueueAttributes(QueueAttributes queueAttributes) {
		this.queueAttributes = queueAttributes;
	}

	@Override
	public void setSqsAsyncClient(SqsAsyncClient sqsAsyncClient) {
		this.sqsAsyncClient = sqsAsyncClient;
	}

	@Override
	public void setAcknowledgementCallback(AcknowledgementCallback<?> acknowledgementCallback) {
		this.acknowledgementCallback = acknowledgementCallback;
	}

	public SqsAsyncClient getSqsAsyncClient() {
		return this.sqsAsyncClient;
	}

	public QueueAttributes getQueueAttributes() {
		return this.queueAttributes;
	}

	@Override
	public AcknowledgementCallback<?> getAcknowledgementCallback() {
		return this.acknowledgementCallback;
	}

}
