# myosgi

A web application using Apache Karaf 4.0.10, CXF 3.1.14 and QLACK2.

[Display exported services](http://localhost:8181/cxf?_wadl)

The following configuration files should be added in the karaf/etc folder:

```
# com.eurodyn.qlack2.util.liquibase.cfg

liquibase.repUser=mysogi_rep
datasource=myosgi-ds
liquibase.defaultSchema=qlack2test
liquibase.appRole=myosgi_app_role
liquibase.repRole=mysogi_rep_role
```

```
# com.eurodyn.qlack2.util.datasourcegeneric.cfg

driverClass=com.mysql.jdbc.jdbc2.optional.MysqlXADataSource
datasourceType=javax.sql.XADataSource
jdbcURL=jdbc:mysql://localhost:3306/qlack2test?useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci
username=username
password=password
jndiName=jdbc/qlack-ds,jdbc/myosgi-ds
driverParametersMapping=url-jdbcURL,user-username,password-password

# The initial number of connections that are created when the pool is started.
pool.initialSize=10
# The maximum number of active connections that can be allocated from this pool
# at the same time, or negative for no limit.
pool.maxActive=-1
# The maximum number of connections that can remain idle in the pool, without
# extra ones being released, or negative for no limit.
pool.maxIdle=10
# The minimum number of connections that can remain idle in the pool, without
# extra ones being created, or zero to create none.
pool.minIdle=10
# The maximum number of milliseconds that the pool will wait (when there are no
# available connections) for a connection to be returned before throwing an
# exception, or -1 to wait indefinitely.
pool.maxWait=-1
# The SQL query that will be used to validate connections from this pool before
# returning them to the caller. If specified, this query MUST be an SQL SELECT
# statement that returns at least one row
pool.validationQuery=select 1
# The indication of whether objects will be validated before being borrowed
# from the pool. If the object fails to validate, it will be dropped from the
# pool, and we will attempt to borrow another.
pool.testOnBorrow=true
# Flag to remove abandoned connections if they exceed the removeAbandonedTimout.
# If set to true a connection is considered abandoned and eligible for removal
# if it has been idle longer than the removeAbandonedTimeout. Setting this to
# true can recover db connections from poorly written applications which fail
# to close a connection.
pool.removeAbandoned=false
#  Timeout in seconds before an abandoned connection can be removed.
pool.removeAbandonedTimeout=300
```

```
# com.eurodyn.qlack2.fuse.mailing.cfg

# Whether to auto-start the mail queue monitor thread
autostart=true
# How often to check for new queued emails (in msec)
interval=10000
# Maximum number of tries to send a previously failed e-mail
maxTries=3

server.debug=false
server.host=localhost
server.port=port
server.username=username
server.password=password
server.smtp.starttls.enable=false
```

After you have clean started karaf, execute the following commands:
`feature:repo-add mvn:gr.ioannis/myosgi-karaf-features/1.0.0/xml/features`
`feature:install myosgi`