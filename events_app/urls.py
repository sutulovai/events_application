from django.conf.urls import url

from . import views

urlpatterns = [
    url(
        r'^api/user/(?P<pk>[0-9]+)$',
        views.process_users,
        name='process_users_get_one_update_delete'
    ),
    url(
        r'^api/users/$',
        views.process_users_post_get,
        name='process_users_save_or_get_all'
    ),
    url(
        r'^api/participant/(?P<pk>[0-9]+)$',
        views.process_participant,
        name='process_participant_get_one_update_delete'
    ),
    url(
        r'^api/participants/$',
        views.process_participant_post_get,
        name='process_participant_save_or_get_all'
    ),
    url(
        r'^api/event/(?P<pk>[0-9]+)$',
        views.process_event,
        name='process_event_get_one_update_delete'
    ),
    url(
        r'^api/event/$',
        views.process_event_post_get,
        name='process_event_save_or_get_all'
    ),
    url(
        r'^api/checkPoint/(?P<pk>[0-9]+)$',
        views.process_checkpoint,
        name='process_check_point_get_one_update_delete'
    ),
    url(
        r'^api/checkPoint/$',
        views.process_check_point_post_get,
        name='process_check_point_save_or_get_all'
    ),
    url(
        r'^api/passedCheckPoint/(?P<pk>[0-9]+)$',
        views.process_passed_check_point,
        name='process_passed_check_point_get_one_update_delete'
    ),
    url(
        r'^api/passedCheckPoints/$',
        views.process_passed_check_point_post_get,
        name='process_passed_check_point_save_or_get_all'
    ),

]
