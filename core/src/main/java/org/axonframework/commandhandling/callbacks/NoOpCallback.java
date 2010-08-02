/*
 * Copyright (c) 2010. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.commandhandling.callbacks;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandContext;

/**
 * Callback that does absolutely nothing when invoked. For performance reasons, an instance of this callback can be
 * obtained using <code>NoOpCallback.INSTANCE</code>. A generics-compatible alternative is provided by
 * <code>NoOpCallback.&lt;C&gt;instance()</code>.
 *
 * @author Allard Buijze
 * @param <C> The type of command
 * @since 0.6
 */
public final class NoOpCallback<C> implements CommandCallback<C, Object> {

    /**
     * A statically available instance of the NoOpCallback. Provided for performance reasons.
     * <p/>
     * For generics support, consider using the {@link #instance()} method.
     */
    public static final NoOpCallback INSTANCE = new NoOpCallback();

    /**
     * Method provided to return a generics compatible version of the {@link #INSTANCE}. This method will always return
     * the same instance of the NoOpCallback, for performance reasons.
     * <p/>
     * <em>Usage example: </em>
     * <p/>
     * <code>commandBus.dispatch(new MyCommand(), NoOpCallback.&lt;MyCommand&gt;instance());</code>
     *
     * @param <C> The type of command
     * @return a statically available instance of the NoOpCallback
     */
    @SuppressWarnings({"unchecked"})
    public static <C> NoOpCallback<C> instance() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * This implementation does nothing.
     */
    @Override
    public void onSuccess(Object result, CommandContext<C> context) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * This implementation does nothing.
     */
    @Override
    public void onFailure(Throwable cause, CommandContext<C> context) {
    }
}