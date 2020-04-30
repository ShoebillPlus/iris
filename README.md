# 脚手架

Intelligent remote information system

GET (选择)：从服务器上获取一个具体的资源或者一个资源列表。
POST （创建）： 在服务器上创建一个新的资源。
PUT（更新）：以整体的方式更新服务器上的一个资源。
PATCH （更新）：只更新服务器上一个资源的一个属性。
DELETE（删除）：删除服务器上的一个资源。
HEAD ： 获取一个资源的元数据，如数据的哈希值或最后的更新时间。
OPTIONS：获取客户端能对资源做什么操作的信息。

200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
204 NO CONTENT - [DELETE]：用户删除数据成功。
400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。

https://www.cnblogs.com/fu-yong/p/9052623.html
